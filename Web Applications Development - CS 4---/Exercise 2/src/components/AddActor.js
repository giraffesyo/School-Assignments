import React, { PureComponent } from 'react';
import { Alert, Form, FormGroup, Input, Button } from 'reactstrap';
import PropTypes from 'prop-types';
import isUrl from 'is-url';

class AddActor extends PureComponent {
  state = {
    actorname: '',
    charactername: '',
    photourl: '',
    message: null,
    error: false
  };

  static propTypes = {
    appendActor: PropTypes.func.isRequired
  };

  static defaultProps = {
    appendActor: () => { }
  };

  validateString(str) {
    if (typeof str === 'string' && str.trim().length > 0) {
      return true;
    } else return false;
  }

  handleCharacterNameChange(changeEvent) {
    const charactername = changeEvent.currentTarget.value
    this.setState({ charactername });

  }
  handleActorNameChange(changeEvent) {
    this.setState({ actorname: changeEvent.currentTarget.value });
  }
  handlePhotoUrlChange(changeEvent) {
    this.setState({ photourl: changeEvent.currentTarget.value });
  }

  gather = e => {
    const { actorname, charactername, photourl } = this.state;
    let validation;

    validation = this.validateString(actorname) && this.validateString(charactername)
    if (!validation) {
      this.setState({ error: true, message: "Please enter a value." });
      return
    }
    
    if (!isUrl(photourl)) {
      this.setState({ error: true, message: "Please enter a valid photo url" });
      return
    }
    this.setState({error: false, message: null})

    const { appendActor } = this.props;

    appendActor({ name: actorname, character: charactername, photo: photourl });
  };

  render() {
    const { appendActor } = this.props;
    const { message } = this.state;

    {
      return (
        <div>
          <Alert
            hidden={!message}
            color="danger"
            toggle={() => {
              this.setState({ message: null });
            }}
          >
            {message}
          </Alert>
          <Form id="AddForm">
            <FormGroup>
              <Input
                onChange={this.handleActorNameChange.bind(this)}
                name="actorname"
                placeholder="Name of Actor"
              />
            </FormGroup>
            <FormGroup>
              <Input
                onChange={this.handleCharacterNameChange.bind(this)}
                name="charactername"
                placeholder="Character Name"
              />
            </FormGroup>
            <FormGroup>
              <Input
                onChange={this.handlePhotoUrlChange.bind(this)}
                name="photourl"
                placeholder="Image URL"
              />
            </FormGroup>
            <FormGroup className="add">
              <Button
                onClick={this.gather.bind(this)}
                color="success"
              >
                Add
              </Button>
            </FormGroup>
          </Form>
        </div>
      );
    }
  }
}

export { AddActor };
