export function UserOptions({ option }: { option: string }) {
    return (
        <li>
            <a href="#" className="block px-4 py-2 hover:bg-gray-300 ">{option}</a>
        </li>
    )
}