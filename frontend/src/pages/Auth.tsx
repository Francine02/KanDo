import Button from "../components/auth/Button";
import Title from "../components/auth/Title";

export function Auth() {
    return (
        <div className="bg-[url('/src/assets/bg.png')] bg-cover bg-center h-screen w-screen flex flex-col items-center justify-center text-center space-y-10 px-4">
            <Title />
            <Button />
        </div>
    )
}
