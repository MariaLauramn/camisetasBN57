import * as React from 'react';
import {NavigationBar} from "./navigationBar/NavigationBar";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom"
import {About} from "./about/About";
import {Shirt} from "./shirt/Shirt";
import {useEffect, useState} from "react";
import {ShirtApi} from "../api/ShirtApi";
import {Home} from "./home/Home";
import {FormAddShirt} from "./forms/FormAddShirt";
import {FormEditShirt} from "./forms/FormEditShirt";

export const App = () => {

    const shirtApi = new ShirtApi()

    const [shirts, setShirts] = useState([])


    useEffect(() => {

        shirtApi.getShirts()
            .then(setShirts)

    }, [])

    return <Router>
        <NavigationBar/>
        <Switch>
            <Route exact path="/">
                <Home/>
            </Route>
            <Route path="/shirt">
                <Shirt shirts={shirts}/>
            </Route>
            <Route path="/about">
                <About/>
            </Route>
            <Route path="/formAddShirt">
                <FormAddShirt/>
            </Route>
               <Route path="/formEditShirt">
            <FormEditShirt/>
        </Route>
        </Switch>
    </Router>
}
