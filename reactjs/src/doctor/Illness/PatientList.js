import React, {PureComponent} from 'react';
import Patient from "./Patient";
import './IllnessList.css'

class PatientList extends PureComponent {


    render() {
        const users = this.props.users.map(user =>
            <li key={user.id} className="illnesses-list_li">
                <Patient
                    user={user}/>
            </li>
        );

        return (
            <ul className="ul">
                {users}
            </ul>
        )

    }
}

export default PatientList;