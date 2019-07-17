class FindAnagrams:
    def findAnagrams(self, s:str, p:str):
        if len(s) < len(p):
            return []
        sArr = list(s)
        pArr = list(p)
        






if __name__ == "__main__":
    s = "cbaebabacd"
    p = "abc"
    F = FindAnagrams()
    print(F.findAnagrams(s,p))