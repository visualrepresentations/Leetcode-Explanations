1bool canVisitAllRooms(int** rooms, int roomsSize, int* roomsColSize) {
2    // Basically a bst, but you the current edges are the keys that you have, you enqueue each key into it and you d
3    bool *visited = calloc(roomsSize, sizeof(bool));
4    int *queue = calloc((roomsSize + 1), sizeof(int));
5    for (int i = 0; i < roomsSize; i++) {
6        queue[i] = -1;
7    }
8    int curr = 0;
9    int end = 1;
10    queue[curr] = 0;
11    visited[0] = true;
12
13    while (curr < end) {
14        int v = queue[curr];
15        int size = roomsColSize[v];
16
17        for (int i = 0; i < size; i++) {
18            int w = rooms[v][i];
19            if (!visited[w]) {
20                visited[w] = true;
21                queue[end++] = w;
22            }
23        }
24
25        curr++;
26    }
27
28    for (int i = 0; i < roomsSize; i++) {
29        if (!visited[i]) {
30            free(queue);
31            free(visited);
32            return false;
33        }
34    }
35
36    free(queue);
37    free(visited);
38    return true;
39}