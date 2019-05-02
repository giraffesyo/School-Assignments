const reference = [1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3]
// we're considering four frames
// preload first four frames, as all algorithms require this
const frames = [
  reference.shift(),
  reference.shift(),
  reference.shift(),
  reference.shift(),
]

console.log(reference)
console.log(frames)

const FIFO = (_reference, _frames) => {
  console.log(`-----\nBegin FIFO Logging\n-----`)
  // important to keep track of the order that they were added, so we should declare an array that keeps
  //track of those relative to the index they are in in the frames array
  // 1 represents most recent, 4 represents oldest
  const ages = [4, 3, 2, 1]
  const frames = [..._frames]
  let pageFaultCount = 4 // starts at 4 because of initial 4
  //loop through reference array
  _reference.forEach((page, index) => {
    // check to see if page reference exists in a frame
    const exists = frames.includes(page)
    // if it doesnt exist we have a page fault
    if (!exists) {
      console.log(`-----`)
      console.log(`Fault: ${pageFaultCount + 1}`)
      console.log(
        `Page fault on index ${index +
          3}, page ${page} did not have a reference in any frame.\nAges before incrementing: `,
        ages,
        `\nframes before updating: `,
        frames
      )
      // find the oldest index
      oldestIndex = ages.findIndex(value => value == 4)
      // increment all values of ages
      ages.forEach((_, index) => ages[index]++)
      // change the oldest index to the new value
      frames[oldestIndex] = page
      // set the age of this index to 1, since its the newest now
      ages[oldestIndex] = 1
      // increment count of page faults
      pageFaultCount++
      console.log(
        `Oldest index was: ${oldestIndex} \nnew ages: `,
        ages,
        ` \nnew frames: `,
        frames,
        ``
      )
    }
  })
  console.log(`-----\nEnd FIFO logging\n-----`)

  return pageFaultCount
}

const LRU = (_reference, _frames) => {
  console.log(`-----\nBegin LRU Logging\n-----`)
  // important to keep track of the order that they were added, so we should declare an array that keeps
  //track of those relative to the index they are in in the frames array
  // 1 represents most recent, 4 represents oldest
  const ages = [4, 3, 2, 1]
  const frames = [..._frames]
  let pageFaultCount = 4 // starts at 4 because of initial 4
  //loop through reference array
  _reference.forEach((page, index) => {
    // check to see if page reference exists in a frame
    const exists = frames.includes(page)
    // if it doesnt exist we have a page fault
    if (!exists) {
      console.log(`-----`)
      console.log(`Fault: ${pageFaultCount + 1}`)
      console.log(
        `Page fault on index ${index +
          3}, page ${page} did not have a reference in any frame.\nAges before incrementing: `,
        ages,
        `\nframes before updating: `,
        frames
      )
      // find the oldest index
      oldestIndex = ages.indexOf(Math.max(...ages))
      // increment all values of ages
      ages.forEach((_, index) => ages[index]++)
      // change the oldest index to the new value
      frames[oldestIndex] = page
      // set the age of this index to 1, since its the newest now
      ages[oldestIndex] = 1
      // increment count of page faults
      pageFaultCount++
      console.log(
        `Oldest index was: ${oldestIndex} \nnew ages: `,
        ages,
        ` \nnew frames: `,
        frames,
        ``
      )
    } else {
      // it exists so we don't have a page fault, but we need to update its age
      const index = frames.findIndex(value => value == page)
      // increment all values of ages
      ages.forEach((_, index) => ages[index]++)
      // set the index we found to age 1 (newest)
      ages[index] = 1
    }
  })
  console.log(`-----\nEnd LRU logging\n-----`)

  return pageFaultCount
}

const Optimal = (_reference, _frames) => {
  console.log(`-----\nBegin Optimal Logging\n-----`)
  const frames = [..._frames]
  let pageFaultCount = 4 // starts at 4 because of initial 4
  //loop through reference array
  _reference.forEach((page, index) => {
    // check to see if page reference exists in a frame
    const exists = frames.includes(page)
    // if it doesnt exist we have a page fault
    if (!exists) {
      console.log(`-----`)
      console.log(`Fault: ${pageFaultCount + 1}`)
      console.log(
        `Page fault on index ${index +
          3}, page ${page} did not have a reference in any frame.\nframes before updating: `,
        frames
      )
      // get the indices which represents the job furthers from now (sjf)
      const ages = frames.map(frame => {
        let res = _reference.indexOf(frame, index + 1)
        return res === -1 ? 10000 : res
      })
      const oldestIndex = ages.indexOf(Math.max(...ages))
      // change the oldest index to the new value
      frames[oldestIndex] = page
      // increment count of page faults
      pageFaultCount++
      console.log(`Oldest index was: ${oldestIndex} \nnew frames: `, frames)
    }
  })
  console.log(`-----\nEnd Optimal logging\n-----`)

  return pageFaultCount
}

const LRUPageFaultCount = LRU(reference, frames)
const FIFOPageFaultCount = FIFO(reference, frames)
const OptimalPageFaultCount = Optimal(reference, frames)
console.log(`LRU Page Fault Count: ${LRUPageFaultCount}`)
console.log(`FIFO Page Fault count is: ${FIFOPageFaultCount}`)
console.log(`Optimal Page Fault count is: ${OptimalPageFaultCount}`)
