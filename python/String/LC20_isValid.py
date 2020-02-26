"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.
Example 1:
    Input: "()"
    Output: true

Example 2:
    Input: "()[]{}"
    Output: true

Example 3:
    Input: "(]"
    Output: false

Example 4:
    Input: "([)]"
    Output: false

Example 5:
    Input: "{[]}"
    Output: true
"""

def isValid(s):
    if not s or len(s) == 0:
        return False
    stack = []
    for i in range(len(s)):
        if s[i] == "(":
            stack.append(")")
        elif s[i] == "{":
            stack.append("}")
        elif s[i] == "[":
            stack.append("]")
        else:
            # meet ")" or "}" or "]"
            if(len(stack)==0 or stack.pop() != s[i]):
                return False

    if len(stack) != 0:
        return False
    return True

if __name__ == "__main__":
    s = "([])"
    print(isValid(s))