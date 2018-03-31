//Michael McQuade A01677104
//Run this in node.js

var Graph = require('graph-data-structure')

var graph = Graph()

function calculateWeight(graph, listOfNodes) {
  let sum = 0
  for (let i = 0; i < listOfNodes.length - 1; i++) {
    sum += parseInt(graph.getEdgeWeight(listOfNodes[i], listOfNodes[i + 1]))
  }
  return sum
}

function calculateTotalDistance(graph) {
  let sum = 0
  let nodes = graph.nodes()
  for (let i = 0; i < graph.nodes().length; i++) {
    for (let j = 0; j < graph.nodes().length; j++) {
      let weight = calculateWeight(
        graph,
        graph.shortestPath(nodes[i], nodes[j])
      )
      sum += weight
      //console.log(`source node: ${i}, target node: ${j} `)
      //console.log(`shortest path total weight: ${weight}, sum: ${sum}`)
    }
  }
  return sum
}

//Town A Vertices
graph.addNode('a') //a
graph.addNode('b') //b
graph.addNode('c') //c
graph.addNode('d') //d
graph.addNode('e') //e

//Town A Edges
graph.addEdge('a', 'b', 2) //a -> b
graph.addEdge('b', 'c', 3) //b -> c
graph.addEdge('c', 'e', 5) //c -> e
graph.addEdge('e', 'd', 4) //e -> d
graph.addEdge('d', 'c', 4) //d -> c
graph.addEdge('e', 'a', 7) //e -> a

//Town B Vertices
graph.addNode('f') //f
graph.addNode('g') //g
graph.addNode('h') //h
graph.addNode('i') //i
graph.addNode('j') //j

//Town B Edges
graph.addEdge('f', 'i', 7) //f -> i
graph.addEdge('i', 'j', 4) //i -> j
graph.addEdge('i', 'h', 5) //i -> h
graph.addEdge('j', 'f', 3) //j -> f
graph.addEdge('h', 'g', 4) //h -> g
graph.addEdge('g', 'f', 3) //g -> f

serializedGraph = graph.serialize()
//D to I in both ways, 3 km
graph_d_to_i = Graph(serializedGraph)
graph_d_to_i.addEdge('d', 'i', 3) //d -> i
graph_d_to_i.addEdge('i', 'd', 3) //i -> d

//C to J in both ways, 4km
graph_c_to_j = Graph(serializedGraph)
graph_c_to_j.addEdge('c', 'j', 4) //c -> j
graph_c_to_j.addEdge('j', 'c', 4) //j -> c

//I to E inb oth ways, 10km
graph_i_to_e = Graph(serializedGraph)
graph_i_to_e.addEdge('i', 'e', 10) //i -> e
graph_i_to_e.addEdge('e', 'i', 10) //e -> i

console.log(`Total Node Distance with road from d to i: ${calculateTotalDistance(graph_d_to_i)}`)
console.log(`Total Node Distance with road from c to j: ${calculateTotalDistance(graph_c_to_j)}`)
console.log(`Total Node Distance with road from i to e: ${calculateTotalDistance(graph_i_to_e)}`)
