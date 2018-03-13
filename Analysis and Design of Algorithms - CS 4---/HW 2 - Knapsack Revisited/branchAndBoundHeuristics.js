//Michael McQuade A01677104
//Run this using Node.js or chrome developer tools

/*
In this file, we'll implement heuristic time complexity analysis for the branch and bound method:

The implementation is copied from the other file, brandandbound.js which I wrote prior to making this file, 
with customizable parameters in order to test the algorithm with varying sizes of arrays.
*/

function branchandbound(n, w, v, weights, values) {
  const initialWeights = [...weights]
  const initialValues = [...values]
  const initialWeight = 5
  const initialValue = 0
  function findGreedyBest(weights, values, initialWeight, initialValue) {
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
  const initialBest = findGreedyBest(
    weights,
    values,
    initialWeight,
    initialValue
  )

  weights = [...initialWeights]
  values = [...initialValues]
  function knapsack(n, w, v, weights, values) {
    //find the sum of all remaining values
    let tempValues = [...values]
    tempValues.splice(n - 1) //removes values after n-1
    let tempSum = v
    for (i in tempValues) {
      tempSum += tempValues[i]
    }
    //if we're not better than greedy algorithm, return
    if (tempSum < initialBest) return v //bound part of branch and bound
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
}

TestCases = numberOfCases => {
  const initialWeight = 5
  const initialValue = 0
  const stepSize = 100

  for (let i = stepSize; i <= stepSize * numberOfCases; i = i + stepSize) {
    let initialTime = new Date()
    let weights = Array.from({ length: i }, () => Math.floor(Math.random() * 4))
    let values = Array.from({ length: i }, () => Math.floor(Math.random() * 15))
    let Answer = branchandbound(
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
