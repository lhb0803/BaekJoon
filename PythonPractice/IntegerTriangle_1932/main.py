def solution(n, numbers):
    dp = list()

    dp.append(numbers[0])
    for i in range(1,n):
        li = list()
        for j in range(i+1):
            if j == 0:
                li.append(dp[i-1][j]+numbers[i][j])
            elif j == i:
                li.append(dp[i-1][j-1]+numbers[i][j])
            else:
                li.append(max(dp[i-1][j-1],dp[i-1][j])+numbers[i][j])
        dp.append(li)

    return max(dp[-1])


if __name__ == '__main__':
    n = int(input())
    numbers = list()
    for i in range(n):
        li = list(map(int, input().split()))
        numbers.append(li)
    
    print(solution(n, numbers))