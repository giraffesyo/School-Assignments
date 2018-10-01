import React from 'react'
import Layout from '../components/Layout'
import Image from 'gatsby-image'

import tecLogo from '../images/tec.svg'
import osuLogo from '../images/osu.svg'
import 'typeface-raleway'

import { SectionHeader } from '../blocks/SectionHeader'
import { Education } from '../components/Education'
import { Experience } from '../components/Experience'

const education = {
  schools: [
    { name: 'Oklahoma State University', logo: osuLogo },
    {
      name: 'Monterrey Institute of Technology and Higher Education',
      logo: tecLogo
    }
  ],
  degree: { title: 'B.S. in Computer Science', subtitle: '(expected May 2019)' }
}

class Index extends React.PureComponent {
  render() {
    const {
      props: {
        data: {
          file: {
            childImageSharp: { sizes: MyPhoto }
          }
        }
      }
    } = this

    return (
      <Layout>
        <SectionHeader>About Me</SectionHeader>
        <div className="row">
          <div className="col-12 col-md-4">
            <Image
              sizes={MyPhoto}
              alt="Developer Michael McQuade (giraffesyo) with a live giraffe in Mexico"
            />
          </div>
          <div className="col-12 col-md-8 mt-4 mt-md-0">
            <p>I'm Michael McQuade. </p>

            <p>
              I'm a Computer Science student at Oklahoma State University. I
              spent the last year studying my major abroad in Mexico City,
              Mexico. The experience helped me broaden my horizons as a denizen
              of the world while learning Computer Science from the most
              prestigious school in Mexico.
            </p>
            <p>
              My experiences have been varied, from technical support to helping
              people with fraud at Apple iTunes. Now, I'm finally doing what I
              love, learning to code!
            </p>
            <p>
              I have found that as a programmer, I am solving new problems every
              day. Because of this, work really feels like a game where I just
              have to find the answer to the current level, and when you reach a
              level you've already beaten, the answer is ever so clear.
            </p>
            <p>
              Over the summer I did a software development internship at
              Foundation Software in Strongsville, Ohio. Now, I'm back in
              classes and expect to graduate May 2019.
            </p>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <Education schools={education.schools} degree={education.degree} />
          </div>
        </div>
        <div className="row">
          <div className="col">
            <Experience />
          </div>
        </div>
      </Layout>
    )
  }
}

export const query = graphql`
  query AboutMeQuery {
    file(relativePath: { eq: "michaelmcquade.jpg" }) {
      childImageSharp {
        sizes {
          ...GatsbyImageSharpSizes
        }
      }
    }
  }
`

export default Index
