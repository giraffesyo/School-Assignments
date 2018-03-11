const weights = [2, 1, 3, 2]
const values = [12, 10, 20, 15]
const initialWeight = 5
const initialValue = 0
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

//Initial call to start this off
knapsack(weights.length, initialWeight, initialValue, weights, values)

//Log all solutions found:
//console.log(solutionSet)

//Log highest non negative solution found:
solution = [0, 0]
for (i in solutionSet) {
  if (solutionSet[i][1] >= 0 && solutionSet[i][0] > solution[0])
    solution = solutionSet[i]
}
console.log(solution[0])
