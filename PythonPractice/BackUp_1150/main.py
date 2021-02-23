from queue import PriorityQueue


def solution(n, k, company_list):
    answer = 0
    cable_que = PriorityQueue()
    selected_set = set()

    for i in range(1, n):
        cable = Cable(i - 1, i, company_list[i] - company_list[i - 1])
        cable_que.put(cable)

    while k > 0:
        selected_cable = cable_que.get()
        left = selected_cable.left
        right = selected_cable.right
        length = selected_cable.length
        if left in selected_set or right in selected_set:
            continue
        else:
            answer += length
            selected_set.add(left)
            selected_set.add(right)

            if left > 0 and right < n-1:
                left -= 1
                right += 1

                new_cable = Cable(left, right, company_list[right]-company_list[left] - 2*length)
                cable_que.put(new_cable)

        k -= 1

    return answer


class Cable:

    def __init__(self, left, right, length):
        self.left = left
        self.right = right
        self.length = length

    def __lt__(self, other):
        return self.length < other.length

    def __eq__(self, other):
        return self.length == other.length

    def left(self):
        return self.left
    def right(self):
        return self.right
    def length(self):
        return self.length


if __name__ == '__main__':
    n, k = input().split()
    n = int(n)
    k = int(k)

    company_list = list()
    for i in range(n):

        company_list.append(int(input()))

    print(solution(n, k, company_list))
