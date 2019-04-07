import React from 'react'
import ReactDOM from 'react-dom'
import App, { Process } from './Bankers'
import 'bootstrap-css-only'

ReactDOM.render(
  <App
    initialState={{
      Processes: [
        new Process([0, 1, 0], [7, 5, 3]),
        new Process([2, 0, 0], [3, 2, 2]),
        new Process([3, 0, 2], [9, 0, 2]),
        new Process([2, 1, 1], [2, 2, 2]),
        new Process([0, 0, 2], [4, 3, 3]),
      ],
      request: [1,0,2 ],
      available: [3, 3, 2],
      resourceMaximums: [10, 5, 7],
    }}
  />,
  document.getElementById('root')
)
