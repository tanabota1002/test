package main

import "fmt"

const (
	Sun int = iota //0からの連番になる
	Mon				
	Tue
	Wed
	Thu
	Fri
	Sat
)

//関数の外にconstを出すとグローバルな定数として扱うことができる

const PI = 3.14
const Hello = "Hello, Dogs"

func main() {
	x := PI * 2.5 * 2.5
	fmt.Printf("%.1f\n", x)//Printfにすると　%.<小数点第〇位>f　で小数点の区切りも指定できるようになる
	fmt.Println(Hello)
	fmt.Println(Sun)
}