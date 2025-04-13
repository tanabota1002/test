package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var name string
	fmt.Printf("名前を入力して下さい：")
	scanner := bufio.NewScanner(os.Stdin)

	scanner.Scan()
	name = scanner.Text()

	fmt.Printf("nameは=%s\n", name)
}
