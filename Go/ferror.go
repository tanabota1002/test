// float 32で答えが表示されるプログラム
package main

import "fmt"

//main関数が同一ディレクトリ内に複数あることによるエラーが表示されている
func main() {
	var x, y float32

	x = 7.0
	y = 0.3
	fmt.Println("x*y=", x*y)
}