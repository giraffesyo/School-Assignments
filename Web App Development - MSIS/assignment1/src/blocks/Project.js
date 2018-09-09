import React from 'react'
import { ProjectSlider } from '../blocks/ProjectSlider'
import styled from 'styled-components'

const ProjectWrapper = styled.div`
  margin-bottom: 2rem;
`

class Project extends React.PureComponent {
  render() {
    const {
      props: { title, images, children }
    } = this
    return (
      <ProjectWrapper className="row">
        <div className="col-12 col-md-4">
          <ProjectSlider images={images} alt={title} />
        </div>
        <div className="col-12 col-md-8 mt-4 mt-md-0">{children}</div>
      </ProjectWrapper>
    )
  }
}

export { Project }
