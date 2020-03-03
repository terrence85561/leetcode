class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        freq = {}
        for word in words:  # O(n)
            if word in freq:
                freq[word] += 1
            else:
                freq[word] = 1
        import heapq
        count = []
        res = []
#         for key in freq:#O(nlogn)
#             heapq.heappush(count, (-freq[key], key))

        count = [(-freq[key], key) for key in freq]
        heapq.heapify(count)  # O(n)
        for i in range(k):  # O(klogn)
            res.append(heapq.heappop(count)[1])
        return res
