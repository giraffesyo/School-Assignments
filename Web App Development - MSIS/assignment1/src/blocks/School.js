import React from 'react'
import styled from 'styled-components'

const SchoolRow = styled.div`
  margin-top: 1rem;
  margin-bottom: 1rem;

  img {
    width: 100%;
  }
`

const School = props => {
  const { image, alt } = props
  return (
    <SchoolRow className="row">
      <div className="col-12 col-md-2">
        {image && <img alt={alt + " logo"} src={props.image} />}
      </div>
      <div className="col-12 col-md-10">
        <h3 className="mt-4 mt-md-0 text-center text-md-left">
          {props.children}
        </h3>
      </div>
    </SchoolRow>
  )
}

export { School }
