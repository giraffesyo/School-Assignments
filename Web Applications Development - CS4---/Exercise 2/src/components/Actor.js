import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';

export const ActorShape = {
  photo: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  character: PropTypes.string.isRequired
};

class Actor extends PureComponent {
  static propTypes = { ...ActorShape, onRemove: PropTypes.func.isRequired };
  static defaultProps = {
    photo:
      'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Placeholder_no_text.svg/1024px-Placeholder_no_text.svg.png',
    name: 'Unknown',
    character: 'Unknown'
  };

  render() {
    const { photo, name, character, onRemove } = this.props;
    return (
      <li>
        <span onClick={onRemove} className="removeIcon">
          &times;
        </span>
        <span className="photo">
          <img alt={name} src={photo} />
        </span>
        <span className="name">{name}</span>
        <span className="character">{character}</span>
      </li>
    );
  }
}
export { Actor };
