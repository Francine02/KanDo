import ButtonColor from "./ButtonColor";

export default function Card() {
    return (
        <div className="overflow-auto bg-custom-blue rounded-2xl p-3 text-white text-lg mt-4">
            <div className="flex justify-end pb-2 space-x-2">
                <ButtonColor color="bg-custom-green" />
                <ButtonColor color="bg-custom-blue" />
                <ButtonColor color="bg-custom-purple" />
                <ButtonColor color="bg-custom-pink" />
            </div>

            <textarea
                placeholder="Adicione uma nova tarefa..."
                rows={4}
                className="peer w-full bg-transparent outline outline-0 resize-none placeholder:opacity-60 placeholder:text-white" />
        </div>
    );
}
