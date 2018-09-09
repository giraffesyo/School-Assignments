import styled from 'styled-components'
import { purple } from '../colors'

const SectionHeader = styled.div`
  text-align: center;
  color: ${purple};
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
  font-size: 3rem;
  letter-spacing: 0.5rem;

  &:after {
    display: block;
    content: '';
    width: 80%;
    margin: 0 auto 2rem auto;
    border-bottom: 0.375rem solid ${purple};
  }

  @media screen and (max-width:767px){
    font-size: 2rem;
  }
`

export { SectionHeader }
