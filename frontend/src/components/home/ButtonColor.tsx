export default function ButtonColor({ color }: { color: string }) {
    return (
        <button className={`h-5 w-5 rounded-full border-2 border-white ${color}`}></button>
    )
}
