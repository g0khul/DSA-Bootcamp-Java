# Input:
# abbbccdeab
# Output:
# abbccdeab
# Explanation:
# Since the input string is having the character ‘b’ thrice, we require the characters in the string doesn’t
# repeat themselves more than twice, so we omit ‘b’ and desired string “abbccdeab”.

def omit_extra_characters(s):
    result = []
    count = 0
    for c in s:
        if not result or c != result[-1]:
            result.append(c)
            count = 1
        else:
            count = count + 1
            if count <= 2:
                result.append(c)

    return ''.join(result)

input_string = "abbbbbbbbbbbbbbbbbccdeab"
output_string = omit_extra_characters(input_string)
print(output_string)  # Output: "abbccdeab"
