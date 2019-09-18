    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits = []
        words = []
        for log in logs:
            temp = log.split()[1]
            if temp.isdigit():
                digits.append(log)
            else:
                words.append(log)
        
        words.sort(key = lambda x : x.split()[0])
        words.sort(key = lambda x:x.split()[1:])
        return words+digits