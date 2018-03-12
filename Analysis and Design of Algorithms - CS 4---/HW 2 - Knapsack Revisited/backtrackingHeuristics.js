//Michael McQuade A01677104
//Run this using node.js or chrome developer tools.

//This is the backtracking time complexity tester

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

TestCases = numberOfCases => {
  const initialWeight = 5
  const initialValue = 0
  const stepSize = 1
  for (let i = stepSize; i <= stepSize * numberOfCases; i = i + stepSize) {
    let initialTime = new Date()
    let weights = Array.from({ length: i }, () => Math.floor(Math.random() * 4))
    let values = Array.from({ length: i }, () => Math.floor(Math.random() * 15))
    let Answer = knapsack(
      weights.length,
      initialWeight,
      initialValue,
      weights,
      values
    )
    let endTime = new Date()
    let ElapsedTime = endTime - initialTime
    console.log(
      `Test ${i /
        stepSize}/${numberOfCases}: Array of size ${i} took, in ms, ${ElapsedTime}`
    )
  }
}
TestCases(100)
