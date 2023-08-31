# Input:
# arr: 11 14 16 10 9 8 24 5 4 3
# n: 10
# Output:
# -4

# Explanation:
# The value of F1 is (1 + 1) + (1 + 4) + (1 + 6) + (1 + 0) + (9) + (8) + (2 + 4) + (5) + (4) + (3) which is
# equal to 50 and (50 % 10) is 0 and value of F2 is (11 + 14 + 16 + 10 + 9 + 8 + 24 + 5 + 4 + 3) which is
# equal to 104 and (104 % 10 ) is 4, the value of F is (0 - 4), hence -4 is returned.
# The custom input format for the above case:
# 10
# 11 14 16 10 9 8 24 5 4 3
# (The first line represents 'n', the second line represents the elements of the array 'arr')

def lettered_number_sum(lists, n):
    f1 = 0
    f2 = sum(lists)
    for i in lists:
        f1 += sum_of_digits(i)
    f1 = f1 % 10
    f2 = f2 % 10
    return f1 - f2


def sum_of_digits(val):
    sum = 0
    while val != 0:
        rem = val % 10
        sum = sum + rem
        val = val // 10
    return sum


n = int(input())
lists = list(input().split())
lists = [int(v) for v in lists]
print(lists)

print(lettered_number_sum(lists, n))
