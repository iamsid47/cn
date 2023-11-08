import heapq

def dijkstra(graph, start, end):
    queue, visited, distances, path = [(0, start, [])], set(), {node: float('inf') for node in graph}, {}
    distances[start] = 0

    while queue:
        (cost, node, prev_path) = heapq.heappop(queue)

        if node in visited:
            continue

        visited.add(node)
        path[node] = prev_path + [node]

        if node == end:
            return path[node], distances[node]
        
        for neighbor, weight in graph[node].items():
            if distances[node] + weight < distances[neighbor]:
                distances[neighbor] = distances[node] + weight
                heapq.heappush(queue, (distances[neighbor], neighbor, path[node]))

network_graph = {
    'A': {'B': 2, 'C': 5},
    'B': {'A': 2, 'C': 1, 'D': 7},
    'C': {'A': 5, 'B': 1, 'D': 3},
    'D': {'B': 7, 'C': 3}
}

start_node = 'A'
end_node = 'D'

x = int(input("Enter number of nodes: "))

graph_network = {}

for node in range(x):
    temp_dict = {}
    node = str(input("Enter name of the node: "))
    conn = int(input(f"enter how many connections you want for {node}: "))
    for connection in range(conn):

        node2 = str(input("enter node name: "))
        weight = int(input("enter node weight: "))
        temp_dict[node2] = weight
    
    graph_network[node] = temp_dict

print("Here's the graph: ", graph_network)

shortest_path, total_cost = dijkstra(graph_network, start_node, end_node)
print(f'Shortest path from {start_node} to {end_node}: {shortest_path}')
print(f'Total cost: {total_cost}')