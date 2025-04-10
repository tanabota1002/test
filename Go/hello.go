// 名前を入力するとHello <入力した名前>で表示してくれるプログラム
package main

import "fmt"

func namedisplay(name string) {
	fmt.Printf("Hello %s", name)
}

func main() {
	//varというものが変数宣言となる
	//var 変数名 変数型
	//Printfにすることで変数をPrint内で呼び出しができる
	//fmt.Scan(&変数名)でキーボード入力されたものを変数に格納してくれる
	var user string
	fmt.Printf("名前を入力してください：")
	fmt.Scan(&user)
	namedisplay(user)
}