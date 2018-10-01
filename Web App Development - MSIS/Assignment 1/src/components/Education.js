import React from 'react'
import { Degree } from '../blocks/Degree'
import { School } from '../blocks/School'
import { SectionHeader } from '../blocks/SectionHeader'

class Education extends React.PureComponent {
  render() {
    const {
      props: { schools, degree }
    } = this

    const Schools = schools.map(({ name, logo }) => (
      <School key={name} alt={name} image={logo}>
        {name}
      </School>
    ))

    return (
      <>
        <SectionHeader>Education</SectionHeader>
        <div className="row">
          <div className="col">
            <Degree title={degree.title} subtitle={degree.subtitle} />
          </div>
          <div className="col">{Schools}</div>
        </div>
      </>
    )
  }
}

export { Education }
