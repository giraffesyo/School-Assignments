//Michael McQuade A01677104
//Run this using Node.js or chrome developer tools
var solutionSet = []

function knapsack(n, w, v, weights, values) {
  if (n == 0)
    return [v, w] // returning value and weight when we reach 0 remaining items
  else var currentValues = []
  //Store value returned for n-1 and weight[n-1]
  currentValues[0] = knapsack(
    n - 1,
    w - weights[n - 1],
    v + values[n - 1],
    weights,
    values
  )
  //Store value for other route, where we don't put the item in the knapsack
  currentValues[1] = knapsack(n - 1, w, v, weights, values)

  //Determine the max, not using Math.max() so we can keep track of the weight too
  maxValue = []
  if (currentValues[0][0] > currentValues[0][1]) {
    maxValue = currentValues[0]
  } else {
    maxValue = currentValues[1]
  }

  //Add max value and weight to solution set and return them as array.
  solutionSet.push(maxValue)
  return maxValue
}

TestCases = numberOfCases => {
  const initialWeight = 5
  const initialValue = 0
  const stepSize = 1
  for (let i = stepSize; i <= stepSize * numberOfCases; i = i + stepSize) {
    let initialTime = new Date()
    let weights = Array.from({ length: i }, () => Math.floor(Math.random() * 4))
    let values = Array.from({ length: i }, () => Math.floor(Math.random() * 15))
    solutionSet = []
    knapsack(weights.length, initialWeight, initialValue, weights, values)
    //Determine highest non negative solution found:
    solution = [0, 0]
    for (j in solutionSet) {
      if (solutionSet[j][1] >= 0 && solutionSet[j][0] > solution[0])
        solution = solutionSet[j]
    }
    //console.log(solution)
    let endTime = new Date()
    let ElapsedTime = endTime - initialTime
    console.log(
      `Test ${i /
        stepSize}/${numberOfCases}: Array of size ${i} took, in ms, ${ElapsedTime}`
    )
  }
}
TestCases(23)
