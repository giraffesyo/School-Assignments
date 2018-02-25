import React, { PureComponent } from 'react';
import { Actor } from './Actor';
import PropTypes from 'prop-types';

import isUrl from 'is-url';
import { ActorShape } from './Actor';

function collectString(question) {
  let str;
  do {
    str = prompt(question);
    if (typeof str === 'string' && str.trim().length > 0) {
      break;
    }
    alert('You must provide a value.');
  } while (true);
  return str;
}

function collectImage(question) {
  let str;
  do {
    str = collectString(question);
    if (isUrl(str)) {
      break;
    }
    alert('You must provide a valid link to an image.');
  } while (true);
  return str;
}

class ActorList extends PureComponent {
  static propTypes = {
    actors: PropTypes.arrayOf(PropTypes.shape(ActorShape)),
    appendActor: PropTypes.func.isRequired,
    removeActorByIndex: PropTypes.func.isRequired
  };

  static defaultProps = {
    actors: [],
    appendActor: () => { },
    removeActorByIndex: () => { }
  };

  gather = () => {
    const name = collectString("What is the actor's name?");
    const character = collectString("What is the character's name?");
    const photo = collectImage('Please provide a link to the photo.');

    const { appendActor } = this.props;

    appendActor({ name, character, photo });
  };

  render() {
    const { actors, removeActorByIndex } = this.props;
    return (
      <div className="list">
        <h1>Game of Thrones</h1>
        <ul>
          {actors.map((actor, i) => (
            <Actor
              key={`actor-${i}`}
              {...actor}
              onRemove={() => removeActorByIndex(i)}
            />
          ))}
        </ul>
        <div className="add">
          <button onClick={this.gather}>Add</button>
        </div>
      </div>
    );
  }
}
export { ActorList };
