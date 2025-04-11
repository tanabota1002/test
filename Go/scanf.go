package main

import "fmt"

func main() {
	var n, m int

	fmt.Printf("２つの整数を入力してください：")
	fmt.Scanf("%d %d", &n, &m)
	fmt.Printf("%dと%dの合計は%d", n, m, n+m)
}