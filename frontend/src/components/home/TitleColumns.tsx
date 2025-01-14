interface TitleColumnsProps {
    title: string;
    quantity: number;
}

export default function TitleColumns({ title, quantity }: TitleColumnsProps) {
    return (
        <div className="pt-16 flex justify-between items-center">
            <h1 className="text-2xl font-semibold text-gray-900 text-center">{title}</h1>

            <p className="text-sm">{quantity} tarefas</p>
        </div>
    )
}