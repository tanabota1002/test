package main

import "fmt"

func main(){
	//constは定数宣言 型は推論されるが記述したい場合は記述することも可能である
	const PI = 3.14
	const Hello = "Hello, Dogs"

	fmt.Println(PI * 2.5 * 2.5)
	fmt.Println(Hello)
}