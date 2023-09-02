def evaluate_expression(expr):
    operators = []
    operands = []

    precedence = {'+': 1, '-': 1, '*': 2, '/': 2}

    i = 0
    while i < len(expr):
        if expr[i].isdigit():
            num = ""
            while i < len(expr) and expr[i].isdigit():
                num += expr[i]
                i += 1
            operands.append(int(num))
        elif expr[i] in "+-*/":
            while operators and precedence[operators[-1]] >= precedence[expr[i]]:
                op = operators.pop()
                num2 = operands.pop()
                num1 = operands.pop()
                if op == '+':
                    operands.append(num1 + num2)
                elif op == '-':
                    operands.append(num1 - num2)
                elif op == '*':
                    operands.append(num1 * num2)
                elif op == '/':
                    operands.append(num1 // num2)
            operators.append(expr[i])
            i += 1
        else:
            i += 1

    while operators:
        op = operators.pop()
        num2 = operands.pop()
        num1 = operands.pop()
        if op == '+':
            operands.append(num1 + num2)
        elif op == '-':
            operands.append(num1 - num2)
        elif op == '*':
            operands.append(num1 * num2)
        elif op == '/':
            operands.append(num1 // num2)

    return operands[0]

# Example usage
expr = "22+15-2*7/3"
result = evaluate_expression(expr)
print(result)  # Output: 33