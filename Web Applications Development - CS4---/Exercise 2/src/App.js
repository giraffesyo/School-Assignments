import React, { PureComponent } from 'react';
import { ActorList } from './components/ActorList';
import { AddActor } from './components/AddActor';

import { Card, CardBody, CardText, CardTitle, Container, Row, Col } from 'reactstrap'

class App extends PureComponent {
  state = {
    actors: [
      {
        name: 'Emilia Clarke',
        character: 'Daenerys Targaryen',
        photo:
          'https://images-na.ssl-images-amazon.com/images/M/MV5BNjg3OTg4MDczMl5BMl5BanBnXkFtZTgwODc0NzUwNjE@._V1_UX214_CR0,0,214,317_AL_.jpg'
      },
      {
        name: 'Kit Harington',
        character: 'Jon Snow',
        photo:
          'https://images-na.ssl-images-amazon.com/images/M/MV5BMTA2NTI0NjYxMTBeQTJeQWpwZ15BbWU3MDIxMjgyNzY@._V1_UX214_CR0,0,214,317_AL_.jpg'
      },
      {
        name: 'Peter Dinklage',
        character: 'Tyrion Lannister',
        photo:
          'https://images-na.ssl-images-amazon.com/images/M/MV5BMTM1MTI5Mzc0MF5BMl5BanBnXkFtZTYwNzgzOTQz._V1_UY317_CR20,0,214,317_AL_.jpg'
      }
    ]
  };

  appendActor = actor =>
    this.setState(prev => ({
      actors: [...prev.actors, actor]
    }));

  removeActorByIndex = index =>
    this.setState(prev => ({
      actors: [...prev.actors.slice(0, index), ...prev.actors.slice(index + 1)]
    }));

  render() {
    const { appendActor, removeActorByIndex, state: { actors } } = this;
    return (
      <Container>
        <Row>
          <Col className="col-4" />
          <Col className="col-4">
            <Card id="AddCard">
              <CardBody>
                <CardTitle>Add Actor</CardTitle>
                <CardText>
                  <AddActor appendActor={appendActor} />
                </CardText>
              </CardBody>
            </Card>
          </Col>
        </Row>
        <Row>
          <Col className="col-4" />
          <Col className="col-4">
            <div>
              <ActorList
                appendActor={appendActor}
                removeActorByIndex={removeActorByIndex}
                actors={actors}
              />
            </div>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default App;
