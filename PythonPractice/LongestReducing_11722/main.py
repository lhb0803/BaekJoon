def solution(n, arr):
    answer = list()

    for i in range(n):
        answer.append(1)
        for j in range(i):
            if arr[j] > arr[i] and answer[j]+1 > answer[i]:
                answer[i] = answer[j] + 1

    return max(answer)

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    print(solution(n, arr))