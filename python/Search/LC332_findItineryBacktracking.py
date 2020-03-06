class Solution:
    #     def findItinerary(self, tickets: List[List[str]]) -> List[str]:

    #         g = dict()
    #         for ticket in tickets:
    #             src = ticket[0]
    #             des = ticket[1]
    #             if src in g:
    #                 g[src].append(des)
    #             else:
    #                 g[src] = [des]

    #         for key in g:
    #             g[key] = sorted(g[key])

    #         res=['JFK']
    #         total_length = len(tickets)+1

    #         def dfs(g, curr, path,  total_length):
    #             if len(path) == total_length:
    #                 return True
    #             if curr not in g or len(g[curr]) == 0:
    #                 return False

    #             des_list = g[curr]
    #             for i in range (len(des_list)):
    #                 des = des_list[i]
    #                 path.append(des)
    #                 des_list.remove(des)
    #                 if dfs(g, des, path, total_length):
    #                     return True
    #                 path.pop()
    #                 des_list.insert(i, des)

    #         if dfs(g, 'JFK', res, total_length):
    #             return res
    #         return None
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:

        g = dict()
        for ticket in tickets:
            #O(n)
            src = ticket[0]
            des = ticket[1]
            if src in g:
                g[src].append(des)
            else:
                g[src] = [des]

        visit = {}
        for key in g:
            #O(n*nlogn)
            g[key] = sorted(g[key])
            visit[key] = [False] * len(g[key])

        res = ['JFK']
        total_length = len(tickets)+1

        def dfs(g, visit, curr, path,  total_length):
            #O(n!)
            if len(path) == total_length:
                return True
            if curr not in g or len(g[curr]) == 0:
                return False

            des_list = g[curr]
            for i in range(len(des_list)):
                if visit[curr][i]:
                    continue
                des = des_list[i]
                path.append(des)
                visit[curr][i] = True
                if dfs(g, visit, des, path, total_length):
                    return True
                path.pop()
                visit[curr][i] = False

        if dfs(g, visit, 'JFK', res, total_length):
            return res
        return None
