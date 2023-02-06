// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
export interface EnvironmentInterface {
    production: boolean,
    serverUrl: string,
}

export const environment: EnvironmentInterface = {
    production: false,
    serverUrl: "http://localhost:8080"
};


