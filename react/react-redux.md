# react-redux

## step1 install redux & react-redux

use `npm install redux react-redux` 

## step2 define actions

```jsx
//actions.js
export const ADD_TODO = 'ADD_TODO'
export const TOGGLE_TODO = 'TOGGLE_TODO'

export const addTodo = text => ({
  type: ADD_TODO,
  text
})

export const toggleTodo = index => ({
  type: TOGGLE_TODO,
  index
})
```

## step3 define a reducer

```jsx
// reducer.js
import { ADD_TODO, TOGGLE_TODO } from './actions'

const initialState = {
  todos: []
}

const todoApp = (state = initialState, action) => {
  switch (action.type) {
    case ADD_TODO:
      return {
        ...state,
        todos: [
          ...state.todos,
          { text: action.text, completed: false }
        ]
      }
    case TOGGLE_TODO:
      return {
        ...state,
        todos: state.todos.map((todo, index) => {
          if (index === action.index) {
            return { ...todo, completed: !todo.completed }
          }
          return todo
        })
      }
    default:
      return state
  }
}

export default todoApp
```

## step4 create a store

make store.js in your app

```jsx
// store.js
import { createStore } from 'redux'
import todoApp from './reducer'

const store = createStore(todoApp)

export default store
```

you can make it actions & reducers all in store.js 

to make it easyier to use;

## step5 provide the store to your react components using provider

`import store from ‘./store’`

`import Provider from ‘react-redux’;` in App.js

wrap App.js div with `<Provider store={store}></Provider>`

## step6 use redux in your components

```jsx
// ToDoList.js
import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { toggleTodo } from './actions'

const ToDoList = () => {
  const todos = useSelector(state => state.todos)
  const dispatch = useDispatch()

  return (
    <ul>
      {todos.map((todo, index) => (
        <li
          key={index}
          onClick={() => dispatch(toggleTodo(index))}
          style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}
        >
          {todo.text}
        </li>
      ))}
    </ul>
  )
}

export default ToDoList
```

using `useSelector` you can use state value in that components

and using `useDispatch` you can send request to reducer make actions work

`dispatch({type:’Action name’})`

in reducer function

```jsx
function reducer(currentState,action){
//이미 params를 두개 받음 현재state와 state들을 어떻게 바꿀지에 대한 action
	if(currentState===undefined){
		return{
			number:1,
		}
	}
	const newState={...currentState};
	//현재의 state를 불변하게 만들기 위해 복제하고 사용

	if(action.type===’Action name’){
		newState.value1++;
	}
	return newState;
}
```

reducer 란 store 안에 state 를 어떻게 바꿀까