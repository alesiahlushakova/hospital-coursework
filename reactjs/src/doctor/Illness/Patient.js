import React, { Component } from 'react';
import './Illness.css'

import { Tag } from 'antd';


class Patient extends Component {


    render() {
        return (
            <div>
                <Tag className="illness-look">
                    <div  className="illness-look">
                            {this.props.user.username}
                    </div>
                </Tag>
            </div>
        )
    }
}


export default Patient;