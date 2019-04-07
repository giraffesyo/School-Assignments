import React from 'react'

export class Process {
  allocation: number[]
  max: number[]
  need: number[]
  finished = false

  constructor(allocation: number[], max: number[]) {
    this.allocation = allocation
    this.max = max
    this.need = max.map(
      (currentMax, currentIndex) => currentMax - allocation[currentIndex]
    )
  }
}

interface BankersProps {
  initialState: {
    Processes: Process[]
    request: number[]
    available: number[]
    resourceMaximums: number[]
  }
}

interface BankersState {
  Processes: Process[]
  safe: boolean
  currentAvailable: number[]
  availableHistory: number[][]
}

class Bankers extends React.PureComponent<BankersProps, BankersState> {
  // Can process if each value of need is less than or equal to available
  canProcess = (process: Process, available: number[]) => {
    process.need.forEach((need, index) => {
      if (!(need <= available[index])) return false
    })
    return true
  }
  constructor(props: BankersProps) {
    super(props)
    const { canProcess } = this
    const availableHistory = []
    const {
      available: initialAvailable,
      request,
      Processes,
    } = this.props.initialState
    let currentAvailable = request.map(
      (requested, index) => initialAvailable[index] - requested
    )
    availableHistory.push(currentAvailable)
    Processes[1].allocation.forEach((_, index) => {
      Processes[1].allocation[index] += request[index]
      Processes[1].need[index] -= request[index]
    })
    let processing = true
    while (processing) {
      for (let i = 0; i < Processes.length; i++) {
        const currentProcess = Processes[i]
        currentAvailable = availableHistory[availableHistory.length - 1]
        if (
          !currentProcess.finished &&
          canProcess(currentProcess, currentAvailable)
        ) {
          let nextAvailable: number[] = []
          currentAvailable.forEach((value, index) =>
            nextAvailable.push(value + currentProcess.allocation[index])
          )
          availableHistory.push(nextAvailable)

          currentProcess.finished = true
          break
        }
        // if we get to this its because we went through all the processes and they were either finished or couldnt be processed
        if (i === Processes.length - 1) {
          processing = false
          break
        }
      }
    }
    // check if we're in a safe state
    let safe = true
    Processes.forEach(process => {
      if (!process.finished) safe = false
    })
    this.state = {
      safe,
      Processes,
      currentAvailable,
      availableHistory,
    }
  }

  render() {
    const {
      props: {
        initialState: { request },
      },
      state: { Processes, availableHistory, safe },
    } = this
    const headerRow = ['A', 'B', 'C'].map(title => <td key={title}>{title}</td>)
    return (
      <div className="container">
        <h2>Banker's Algorithm</h2>
        <table className="table text-center">
          <thead>
            <tr>
              <th>Process</th>
              <th colSpan={3}>Allocation</th>
              <th colSpan={3}>Need</th>
              <th colSpan={3}>Available</th>
            </tr>
            <tr>
              <td />
              {headerRow}
              {headerRow}
              {headerRow}
            </tr>
          </thead>
          <tbody>
            {Processes.map((process, process_index) => (
              <tr key={'p' + process_index}>
                <td>{'p' + process_index}</td>
                {process.allocation.map((value, allocation_index) => (
                  <td key={'p' + process_index + 'a' + allocation_index}>
                    {value}
                  </td>
                ))}
                {process.need.map((need, need_index) => (
                  <td key={'p' + process_index + 'n' + need_index}>{need}</td>
                ))}
                {availableHistory[process_index].map(
                  (available, available_index) => (
                    <td key={'p' + process_index + 'av' + available_index}>
                      {available}
                    </td>
                  )
                )}
              </tr>
            ))}
            <tr>
              <td colSpan={6} />
              <td>
                <strong>Final:</strong>
              </td>
              {availableHistory[availableHistory.length - 1].map(
                (available, index) => (
                  <td key={'final_available' + index}>{available}</td>
                )
              )}
            </tr>
          </tbody>
        </table>
        The request {request.join(', ')} is{' '}
        {safe ? (
          <span className="text-success h5">safe</span>
        ) : (
          <span className="text-danger h5">unsafe</span>
        )}
        .
      </div>
    )
  }
}

export default Bankers
