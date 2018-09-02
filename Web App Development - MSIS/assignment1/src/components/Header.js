import React from 'react'
import { FaLinkedinIn, FaTwitter, FaGithub } from 'react-icons/fa'
import styled from 'styled-components'
import { lightpurple } from '../colors'

const Nav = styled.nav`
  background-color: rgb(60, 60, 60);
  a {
    font-size: 3rem;
  }
`

const TwitterLink = styled.a`
  &,
  &:hover {
    color: rgb(85, 172, 238);
  }
  &:hover {
    opacity: 0.8;
  }
`

const GithubLink = styled.a`
  &,
  &:hover {
    color: rgb(255, 255, 255);
  }
  &:hover {
    opacity: 0.8;
  }
`

const LinkedinLink = styled.a`
  &,
  &:hover {
    color: rgb(0, 123, 181);
  }
  &:hover {
    opacity: 0.8;
  }
`

const Brand = styled.div`
  font-size: 3rem;
  font-weight: 300;
  color: ${lightpurple};
`

class Header extends React.PureComponent {
  render() {
    return (
      <Nav className="primarynav navbar">
        <ul className="nav">
          <li className="nav-item">
            <GithubLink
              className="nav-link"
              href="https://github.com/giraffesyo"
              target="_blank"
              rel="noopener noreferrer"
            >
              <FaGithub />
              <div className="sr-only">Michael McQuade's Github</div>
            </GithubLink>
          </li>
          <li className="nav-item">
            <TwitterLink
              className="nav-link"
              href="https://twitter.com/giraffesyo"
              target="_blank"
              rel="noopener noreferrer"
            >
              <FaTwitter />
              <div className="sr-only">Michael McQuade's Twitter</div>
            </TwitterLink>
          </li>
          <li className="nav-item">
            <LinkedinLink
              className="nav-link"
              href="https://www.linkedin.com/in/mcquademichael/"
              target="_blank"
              rel="noopener noreferrer"
            >
              <FaLinkedinIn />
              <div className="sr-only">Michael McQuade's Linkedin</div>
            </LinkedinLink>
          </li>
        </ul>
        <Brand className="navbar-brand">Michael McQuade</Brand>
      </Nav>
    )
  }
}

export { Header }
