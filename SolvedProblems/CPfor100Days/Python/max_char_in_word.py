lists = input().split()

Max = -1
index = 0
for i in lists:
    dictionary = {}
    for j in i:
        if dictionary.get(j):
            dictionary.update({j : dictionary.get(j) + 1})
        else:
            dictionary.update({j : 1})
    if Max < max(dictionary.values()):
        Max = max(dictionary.values())
        index = index + 1

print(lists[index])



