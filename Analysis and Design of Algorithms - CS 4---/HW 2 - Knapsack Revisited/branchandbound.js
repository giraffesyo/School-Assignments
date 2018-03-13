//Michael McQuade A01677104
//Run this using node.js or chrome developer tools.

var weights = [2, 1, 3, 2]
var values = [12, 10, 20, 15]
const initialWeight = 5
const initialValue = 0

function findGreedyBest(
  weights = [2, 1, 3, 2],
  values = [12, 10, 20, 15],
  initialWeight = 5,
  initialValue = 0
) {
  //Get ratios of all value pairs
  ratios = []
  for (i in weights) {
    ratios.push(values[i] / weights[i])
  }

  //get initial "best" solution (greedy algorithm, not real max)
  let temporaryWeight = initialWeight
  let bestValue = initialValue

  for (r in ratios) {
    //console.log(`Ratios: ${ratios}\n Weights: ${weights} \n Values: ${values}`)
    //Find the index of the highest ratio'd item in our ratios array
    let bestIndex = ratios.indexOf(Math.max(...ratios))
    if (temporaryWeight - weights[bestIndex] < 0) break
    //console.log(`Best Index found was: ${bestIndex}`)
    //Remove that ratio from our array (modifies array in place)
    ratios.splice(bestIndex, 1)
    //Reduce our weight by the amount of the weight we found to be the best ratio
    temporaryWeight -= weights.splice(bestIndex, 1)[0]
    //Increase our value by the amount of the value we found to be the best ratio
    bestValue += values.splice(bestIndex, 1)[0]
  }
  return bestValue
}

var Best = findGreedyBest()
var iterations = 0

function knapsack(n, w, v, weights, values) {
  iterations++
  //find the sum of all remaining values
  let tempValues = [...values]
  if (n > 0) {
    tempValues.splice(n - 1) //removes values after n-1
  } else tempValues = [] //so we don't restart at end of array when n-index is 0

  let tempSum = v
  for (i in tempValues) {
    tempSum += tempValues[i]
  }
  //if we're not better than greedy algorithm, return
  if (tempSum < Best) return v //bound part of branch and bound
  let vLeft
  let vRight
  let maxV
  if (n == 0) return v
  else if (w == 0)
    //return if we're out of elements
    return v
  else if (w - weights[n - 1] < 0)
    //return if we're out of weight
    //return other leg of branch if we're going to exceed our weight by adding element to knapsack
    return knapsack(n - 1, w, v, weights, values)
  else {
    //Return greatest of two paths recursively
    vLeft = knapsack(
      n - 1,
      w - weights[n - 1],
      v + values[n - 1],
      weights,
      values
    )
    vRight = knapsack(n - 1, w, v, weights, values)
    maxV = Math.max(vLeft, vRight)
    if (maxV > Best) Best = maxV //Get new best
    return maxV
  }
}

const Answer = knapsack(
  weights.length,
  initialWeight,
  initialValue,
  weights,
  values
)

console.log(Answer)
console.log(`Iterations: ${iterations}`)
