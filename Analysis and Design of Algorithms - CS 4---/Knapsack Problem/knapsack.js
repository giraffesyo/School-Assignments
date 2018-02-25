//Michael McQuade A01677104
//Run this using node.js or chrome developer tools.

function knapsack(n, w, v, weights, values) {
  if (n == 0) return v
  else if (w == 0) return v
  else if (w - weights[n - 1] < 0) return knapsack(n - 1, w, v, weights, values)
  else
    return Math.max(
      knapsack(n - 1, w - weights[n - 1], v + values[n - 1], weights, values),
      knapsack(n - 1, w, v, weights, values)
    )
}

const weights = [2, 1, 3, 2]
const values = [12, 10, 20, 15]
const initialWeight = 5
const initialValue = 0

console.log(
  `Found max value of: ${knapsack(
    weights.length,
    initialWeight,
    initialValue,
    weights,
    values
  )}`
)
