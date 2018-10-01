import React from 'react'
import 'bootstrap-css-only'

import './main.css'
import { Header } from './Header'

class Layout extends React.PureComponent {
  render() {
    return (
      <>
        <Header />
        <div className="container">{this.props.children}</div>
      </>
    )
  }
}

export default Layout
