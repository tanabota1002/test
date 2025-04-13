package main

import (
	"fmt"
	"os"
)

func main() {
	if len(os.Args) < 3 {
		fmt.Printf("引数を二個指定してください")
		os.Exit(1)
	}

	fmt.Printf("実行ファイル名：%s\n", os.Args[0])
	fmt.Printf("引数１：%s\n", os.Args[1])
	fmt.Printf("引数2：%s\n", os.Args[2])
}
