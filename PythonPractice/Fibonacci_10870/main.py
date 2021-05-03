def solution(n):
    fib = list()
    fib.append(0)
    fib.append(1)

    if n >= 2:
        for i in range(2, n+1):
            fib.append(fib[i-1] + fib[i-2])
    
    return fib[n]

if __name__ == '__main__':
    print(solution(int(input())))