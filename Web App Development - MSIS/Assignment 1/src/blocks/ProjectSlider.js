import React from 'react'
import Slider from 'react-slick'
import styled from 'styled-components'
import { purple } from '../colors'

const slicksettings = {
  dots: true,
  infinite: true,
  arrows: false,
  speed: 500,
  slidesToShow: 1,
  slidesToScroll: 1
}

const StyledDots = styled.ul`
  li button::before {
    color: ${purple} !important;
    opacity: 0.5;
    font-size: 1rem;
  }
`

class ProjectSlider extends React.PureComponent {
  render() {
    const {
      props: { images, alt }
    } = this

    const items = Array.isArray(images) ? (
      images.map((image, index) => (
        <div key={alt + index}>
          <img className="img-fluid" src={image} alt={alt} />
        </div>
      ))
    ) : (
      <img className="img-fluid" src={images} alt={alt} />
    )
    return (
      <Slider
        appendDots={dots => <StyledDots>{dots}</StyledDots>}
        {...slicksettings}
      >
        {items}
      </Slider>
    )
  }
}

export { ProjectSlider }
