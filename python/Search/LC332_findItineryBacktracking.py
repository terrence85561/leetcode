class Solution:
    def findItineraryHierholzerAlgorithm(self, tickets: List[List[str]]) -> List[str]:
        graph = {}
        for ticket in tickets:
            # O(n)
            src = ticket[0]
            des = ticket[1]
            if src in graph:
                graph[src].append(des)
            else:
                graph[src] = [des]

        for key in graph:
            # O(nlogn)
            graph[key] = sorted(graph[key], reverse=True)

        path = []

        def dfs(graph, path, src):
            # O(n) time, traverse each edge once
            if src not in graph:
                des_list = None
            else:
                des_list = graph[src]
            while des_list:
                nextDes = des_list.pop()
                dfs(graph, path, nextDes)

            path.append(src)

        dfs(graph, path, 'JFK')
        return path[::-1]
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = {}
        for ticket in tickets:
            # O(n)
            src = ticket[0]
            des = ticket[1]
            if src in graph:
                graph[src].append(des)
            else:
                graph[src] = [des]

        visit = {}
        for key in graph:
            # O(nlogn)
            visit[key] = [False] * len(graph[key])
            graph[key] = sorted(graph[key])

        path = ['JFK']
        l = len(tickets) + 1

        def dfs(graph, visit, l, path, cur):
            # O(n!)
            if len(path) == l:
                return True
            if cur not in graph:
                return False

            for i in range(len(graph[cur])):
                des = graph[cur][i]
                if visit[cur][i]:
                    continue

                visit[cur][i] = True
                path.append(des)

                if dfs(graph, visit, l, path, des):
                    return path

                path.pop()
                visit[cur][i] = False
            return False

        if dfs(graph, visit, l, path, 'JFK'):
            return path
        return None
